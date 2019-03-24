import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server;
		BufferedReader br;
		try {
			server = new ServerSocket(8888);
			while (true) {
				Socket socket = server.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestHead = br.readLine();// ����ͷ
//				System.out.println(requestHead);
				// ��ȡ�������Դ
				String resource = handleString(requestHead);
				// ��ȡ�������ʵ�ļ�
				StringBuffer responseMsg = new StringBuffer();
				// ������Ӧ
				responseMsg = response(resource);
				send(responseMsg, socket);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * ��ȡ�������Դ
	 * 
	 * @param requestHead
	 * @return
	 */
	public static String handleString(String requestHead) {
		String[] res = requestHead.split(" ");
		@SuppressWarnings("unused")
		String method = res[0];// ���󷽷�
		String resource = "";// ��Դming
		if (res[1].contains("/")) {
			String[] s = res[1].split("/");
			// �ļ���
			resource = s[s.length - 1];
//			System.out.println(resource);
		}
		return resource;
	}

	/**
	 * ����
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
	 * ������Ӧҳ��
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static StringBuffer response(String resource) throws IOException {
		StringBuffer msg = new StringBuffer();
		if(resource.equals("test")) {
			msg.append("HTTP/1.1 200 OK\n\r");
			msg.append("Content-Type:text/html\n\n");
			String data = "";
			data = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
					+ "<title>MyTest</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "	response Ok\r\n" + "</body>\r\n"
					+ "</html>";
			msg.append(data);
//			System.out.println("ok");
		}
		return msg;

	}
}
