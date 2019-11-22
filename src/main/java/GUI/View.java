package GUI;

/** */
public class View {
	
	public int combined_status[][];
	public static void Renew_Dialog(){};
	public static void Renew_map(){};
	public static void Renew_status(){};
	public static void Renew_status_detail(){};
	public static void Renew_token(){};
	public static void Renew_turn(){};

//	public int setstatus_calculate(int s, String status){};
	public void show_dialog(String s){};
	public void show_dialog_answer(){};

	public void show_boss(){};
	public void show_monster(){};

	public int Dice(){
		double randomValue = Math.random();
		int intValue=(int)(randomValue * 6)+1;
		return intValue;
	}
}
