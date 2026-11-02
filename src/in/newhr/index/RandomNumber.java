package in.newhr.index;

import java.util.Random;

public class RandomNumber {
	public static Long generateRandomNumber() {
		Random rd=new Random();
		long r=rd.nextLong();
		if(r<0) {
			r=r*-1;
		}
		int count=0;
		long res=0;
		while(count<15) {
			long rem=r%10;
			res=(res*10)+rem;
			r=r/10;
			count++;
		}
		return res;
	}
}
