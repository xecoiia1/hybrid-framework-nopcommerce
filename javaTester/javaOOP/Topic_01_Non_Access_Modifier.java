package javaOOP;

public class Topic_01_Non_Access_Modifier {
	
		//Static: Variable/ Method
		//Không cần phải khởi tạo Instance/Obj khi cần sử dụng
		//Dùng cho tất cả Instance/Obj
		//Phạm vi cho toàn bộ system
		//Có thể override được
		static String browserName = "Chrome";
		
		//Non-Static
		String serverName = "Developer";
		
		public static void main(String[] arg) {
			System.out.println(browserName);
			
			
			Topic_01_Non_Access_Modifier topic = new Topic_01_Non_Access_Modifier();
			
			System.out.println(topic.serverName);
		}
}
