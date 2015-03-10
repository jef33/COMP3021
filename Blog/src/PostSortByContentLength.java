import java.util.Comparator;


public class PostSortByContentLength implements Comparator<Post>{

	@SuppressWarnings("finally")
	@Override
	public int compare(Post o1, Post o2) {
		try{
			if(o1.getContent().length() < o2.getContent().length())
				return -1;
			else if(o1.getContent().length() > o2.getContent().length())
				return 1;
			else
				return 0;
		}catch(Exception e){
			return 0;
		}
	}

}
