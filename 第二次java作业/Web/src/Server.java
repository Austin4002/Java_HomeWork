import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {

	public static String uri1 = "";
	public static String uri2 = "";
	public static String method;// 请求方法
	public static Map<String, String> map;

	public static void main(String[] args) {
		ServerSocket server;
		mapping();
		try {
			server = new ServerSocket(8888);
			while (true) {
				Socket socket = server.accept();
				new Thread(() -> {
					System.out.println("一个客户端建立了连接");
					BufferedReader br;
					String requestHead = null;
					try {
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						// 获取请求头
						requestHead = br.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					// 处理请求头
					if (requestHead != null) {
						handleString(requestHead);
						// 生成响应
						StringBuffer responseMsg = new StringBuffer();
						try {
							responseMsg = response();
							// 发送
							send(responseMsg, socket);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}).start();

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 处理请求头
	 * 
	 * @param requestHead
	 * @return
	 */
	public static void handleString(String requestHead) {
		String[] res = requestHead.split(" ");
		method = res[0].toLowerCase();// 请求方法
		if (method.equals("get")) {
			if (res[1].contains("/")) {
				String[] s = res[1].split("/");// /t/1
				uri1 = s[s.length - 2];
				uri2 = s[s.length - 1];
			}
		}
	}

	/**
	 * 发送
	 * 
	 * @param msg
	 * @param socket
	 * @throws IOException
	 */
	public static void send(StringBuffer msg, Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		os.write(msg.toString().getBytes());
		os.close();
	}

	/**
	 * 生成响应信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public static StringBuffer response() throws Exception {
		StringBuffer msg = new StringBuffer();
		String clz_method = map.get("/" + uri1 + "/" + uri2);
		System.out.println(clz_method);
		if (clz_method != null) {
			String[] temp = clz_method.split("/");
			String clazz = temp[temp.length-2];
			String method = temp[temp.length-1];
			// 状态行
			msg.append("HTTP/1.1 200 OK\n\r");
			msg.append("Content-Type:text/html\n\n");
			Class<?> clz = Class.forName(clazz);// 加载字节码对象
			Object obj = clz.getDeclaredConstructor().newInstance();// 实例化
			Method methods = clz.getMethod(method);// 获取类中的方法
			String data = "";
			data = (String) methods.invoke(obj);// 执行
			msg.append(data);
		} else {
			msg.append("HTTP/1.1 404 NOT FOUND\n\r")
			.append("Content-Type:text/html\n\n")
			.append("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
							+ "<title>404 Not Found</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "	您访问的路径不存在\r\n"
							+ "</body>\r\n" + "</html>");
		}
		return msg;
	}

	private static void mapping() {
		MapHandler analysis = new MapHandler();
		map = analysis.Start();// {/t/1=test/res, /t/2=test/res2}
		System.out.println(map);

	}
}
