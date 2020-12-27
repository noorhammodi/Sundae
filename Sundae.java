
public class Sundae {
	//import java.util.*;
	
		private String flavor;
		private int scoops;
		private boolean nuts;
		private double cost;
		private static int nbSundaes;
		
		public Sundae() {
			this.flavor="";
			this.scoops=0;
			this.nuts=false;
			this.cost=0.0;
			Sundae.nbSundaes+=1;
		}
		public Sundae( String flavor,int scoops,boolean nuts) {
			this.scoops=scoops;
			this.flavor=flavor;
			this.nuts=nuts;
			Sundae.nbSundaes+=1;
			calcCost();
		}
		public Sundae (Sundae original) {
			this.flavor=original.flavor;
			this.scoops=original.scoops;
			this.nuts=original.nuts;
			this.cost=original.cost;
			Sundae.nbSundaes+=1;
			
		}
		
		
		public String getFlavor() {
			return flavor;
		}
		public void setFlavor(String flavor) {
			this.flavor = flavor;
		}
		public int getScoops() {
			return scoops;
		}
		public void setScoops(int scoops) {
			this.scoops = scoops;
		}
		public boolean getNuts() {
			return nuts;
		}
		public void setNuts(boolean nuts) {
			this.nuts = nuts;
		}
		public double getCost() {
			return cost;
		}
		
		public static int getNbSundaes() {
			return nbSundaes;
		}
		
		public String toString() {
			return "Sundae with " + scoops + " scoops of " + flavor + " with nuts " + nuts + " for a cost of " + cost ;
		}
		public void updateCost() {
			this.calcCost();
		}
		private void calcCost() {
			cost=(1.5*scoops);
			if (nuts) {
				cost=cost+1.25;
			}
		}
		public boolean equals(Sundae s1) {
			return (this.scoops==s1.scoops)&&(this.nuts==s1.nuts);
		}
		
		
	}

