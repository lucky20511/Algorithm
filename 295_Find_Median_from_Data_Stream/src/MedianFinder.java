import java.util.*;


public class MedianFinder {

	public static void main(String[] args){
		
		MedianFinder sol = new MedianFinder();
		sol.addNum(-1);
		sol.addNum(-2);
		sol.addNum(3);
		System.out.println(sol.findMedian());
		
		
	}
	
	
	
	

	List<Integer> list;

	/** initialize your data structure here. */
	public MedianFinder() {
		list = new ArrayList<Integer>();
	}

	public void addNum(int num) {
		int idx = binarySearch(list, num);
		//System.out.println("==="+idx);
		list.add(idx, num);
	}

	private int binarySearch(List<Integer> list, int num){
		int ret = list.size();
		int start = 0, end = list.size()-1;
		while(start <= end){
			int mid = start + (end-start)/2;
			//System.out.println(start +" " + mid + " " + end);
			if(list.get(mid) > num){
				ret = mid;
				end = mid - 1;
			}else{
				start = mid+1;
			}
		}
		return ret;
	}


	public double findMedian() {
		if(list.size() % 2 == 1){
			return (double)list.get((list.size()-1)/2);
		}else{
			return (double)(list.get((list.size()-1)/2) + list.get(((list.size()-1)/2) + 1))/2;
		}
	}
	
	
}
