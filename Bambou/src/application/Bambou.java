package application;




public class Bambou {
	private int id;
	private String type;
	private String couleur;
	private int taille;
	
	    
	    
		public Bambou(String type, String couleur,int taille) {
			super();
			this.id++;
			this.type = type;
			this.couleur = couleur;
			this.taille = taille;
		}
		public Bambou(int id,String type, String couleur,int taille) {
			super();
			this.id=id;
			this.type = type;
			this.couleur = couleur;
			this.taille = taille;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getCouleur() {
			return couleur;
		}


		public void setCouleur(String couleur) {
			this.couleur = couleur;
		}


		public int getTaille() {
			return taille;
		}


		public void setTaille(int taille) {
			this.taille = taille;
		}




		@Override
		public String toString() {
			return "Bambou [id=" + id + ", type=" + type + ", couleur=" + couleur + ", taille=" + taille
					+  "]";
		}
	    
	    
	    
}
