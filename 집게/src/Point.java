
public class Point {

	static int level=1;
	static int pattyPoint;
	static int vegetablesPoint;
	static int bunPoint;
	static int produceNum;
	static int consumeNum_1;
	static int consumeNum_2;
	static int consumeNum_3;
	static int consumeNum_4;

	
	public Point(int level, int pattyPoint, int vegetablesPoint, int bunPoint, int produceNum, int consumeNum_1, int consumeNum_2, int consumeNum_3, int consumeNum_4) {
		
		
	}
	public Point() {
		// 생성자 하나더 만들자
	}
	public String toString() {
		return level+","+produceNum;
	}
	
	/*
	public String toString() {
		return level;
	}
	 */
}
