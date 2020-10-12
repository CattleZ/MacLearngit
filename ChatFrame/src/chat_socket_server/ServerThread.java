package chat_socket_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ServerThread extends Thread {

	//服务器端实例化一个服务器端的套接字，用来监听客户端
	public ServerSocket serverSocket;
	//用来存储上线用户的信息
	public Vector<String> messages;
	//用来存储客户端的用户
	public Vector<ClientThread> clients;
	//用户ID+登陆状态
	public Map<Integer, String> users;
	
	public BroadCast broadcast;
	//通信端口
	public int Port = 5000;
	//判断是否登陆
	public boolean login = true;
	//服务器框架
	public ServerFrame serverFrame;
	
	private boolean flag_exit = false;
	//初始化服务器
	public ServerThread(ServerFrame serverFrame){
		//服务器框架
		this.serverFrame = serverFrame;
		//消息存储
		messages = new Vector<String>();
		//客户端存储
		clients = new Vector<ClientThread>();
		//用户存储
		users = new HashMap<Integer, String>();
		
		try {
			//创建一个具体的实例
			serverSocket = new ServerSocket(Port);
		} catch (IOException e) {
			this.serverFrame.setStartAndStopUnable();
			System.exit(0);
		}
		broadcast = new BroadCast(this);
		broadcast.setFlag_exit(true);
		broadcast.start();
	}
	
	@Override
	public void run() {
		Socket socket;
		while(flag_exit){
				try {
					if(serverSocket.isClosed()){
						flag_exit = false;
					}else{
						try{
							socket = serverSocket.accept();
						}catch(SocketException e){
							socket = null;
							flag_exit = false;
						}
						//监听是不是接收到连接请求
						if(socket != null){
							//初始化客户端的请求
							ClientThread clientThread = new ClientThread(socket, this);
							//设置客户端可以开启通信
							clientThread.setFlag_exit(true);
							//开启客户端
							clientThread.start();
							//添加一个客户端
							synchronized (clients) {
								clients.addElement(clientThread);
							}
							//添加一个上线的用户记录
							synchronized (messages) {
								users.put((int) clientThread.getId(), "@login@");
								messages.add(clientThread.getId() + "@clientThread");
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
//停止服务器
	public void stopServer() {
		try {
			if(this.isAlive()){
				serverSocket.close();
				setFlag_exit(false);
			}
		} catch (Throwable e) {}
	}

	public void setFlag_exit(boolean b) {
		flag_exit = b;
	}
}
