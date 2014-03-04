package ex07_03;

public class Pascal {
	static final int DEPTH = 12;
	private int[][] pt;

	public Pascal(){
		pt = new int[DEPTH][];
		for(int i = 0; i < DEPTH; i++){
			for(int j = 0; j < i + 1; j++){
				//System.out.println(i + " " + j);
				System.out.println(j);
				pt[i] = new int[i + 1];
				pt[i][0] = 1;
				if(j == i){
					pt[i][j] = 1;
				}
			}
		}
		for(int i = 2;i < DEPTH; i++)
			for(int j = 1; j < i ; j++){
				pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
	}


	public void show(){
		for(int i = 0; i < DEPTH; i++){
			for(int j = 0; j < pt[i].length; j++){
				System.out.print(pt[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Pascal p = new Pascal();
		p.show();

	}

}
