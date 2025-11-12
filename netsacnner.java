import java.net.*;
public class Main {
	public static void main(String[] args)throws Exception {
		String sub="192.168.0.";
		int timeout = 100;
			long s=0,m=0,h=0,ms=0;
		long st=System.currentTimeMillis();
		for(int i=1;i<= 225;i++){
			String host= sub+i;
			InetAddress ip= InetAddress.getByName(host);
			if(ip.isReachable(timeout)){
				System.out.println(host+" is up.\n");
				for(int port=1;port<=600;port++){
			if(portOpen(host,port,timeout)==1){
				System.out.println(port+" Port is open.");
			}
				}
				System.out.println();
			}
		}
		long et=System.currentTimeMillis();
	long ext=et-st;
	if(ext>1000){
		s=ext/1000;
		ms=ext%1000;
		if(s>60){
			m=s/60;
			s=s%60;
			if(m>60){
				h=m/60;
				m=m%60;
			}
		}
	}
	System.out.println(" ");
	System.out.println("Scanning time is "+h+"hr:"+m+"min:"+s+"sec:"+ms+"ms");
	}
public static int portOpen(String h,int p, int t){
	try(Socket socket=new Socket()){
  socket.connect(new InetSocketAddress(h,p),t);
	return 1;
	}
	catch(Exception e){
		return -1;
	}
}
}