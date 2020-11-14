package module2;

import java.util.*;

public class Positions {
	public float scalar(Points v1, Points v2) {
		return v1.getX()*v2.getY() - v2.getX()*v1.getY();
	}
	
	public void vertexSearch(Points[] s, ArrayList<Points> p) {
		Points vect1 = new Points(s[1].getX() - s[0].getX(), s[1].getY() - s[0].getY());
		Points vect2 = new Points(s[1].getX() - s[2].getX(), s[1].getY() - s[2].getY());
		Points vect3 = new Points(s[3].getX() - s[2].getX(), s[3].getY() - s[2].getY());
		Points vect4 = new Points(s[3].getX() - s[0].getX(), s[3].getY() - s[0].getY());
		for (int j = 0; j < p.size(); j++) {
			Points vectDot1 = new Points(p.get(j).getX() - s[0].getX(), p.get(j).getY() - s[0].getY());
			Points vectDot2 = new Points(p.get(j).getX() - s[2].getX(), p.get(j).getY() - s[2].getY());
			if (scalar(vect1,vectDot1) < 0 && scalar(vect4,vectDot1) > 0 && scalar(vect2,vectDot2) > 0 && scalar(vect3,vectDot2) < 0)
				System.out.printf("%d\n",2);
			else
				if (scalar(vect1,vectDot1) > 0 || scalar(vect4,vectDot1) < 0 || scalar(vect2,vectDot2) < 0 || scalar(vect3,vectDot2) > 0)
					System.out.printf("%d\n",3);
				else {
					int flag = 0;
					for (int i = 0; i < s.length; i++) {
						if (p.get(j).getX() == s[i].getX() && p.get(j).getY() == s[i].getY()) {
							System.out.printf("%d\n",0);
							flag = 1;
						}
					}
					if (flag == 0)
						System.out.printf("%d\n",1);
				}
		}
	}
}