import java.io.IOException;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("input.in");
		remplissage(n);
		Output.output(n.caches, "test.out");
	}

	public static void remplissage(Network n) {
		for (EndPoint e : n.endPoints) {
			for (Request r : e.requests) {
				for (Cache c : n.caches) {
					Video v = r.video;
					if (v.poids < c.max_size - c.size) {
						c.videos.add(v);
						c.size += v.poids;
						break;
					}
				}
			}
		}
		remplissage2(n);
	}

	public static void remplissage2(Network n){
		for (EndPoint e : n.endPoints) {
			e.rapport=new float[e.requests.length];
			for(int i = 0;i<e.requests.length;i++) {
				e.rapport[i]=e.requests[i].nbDemandes/e.requests[i].video.poids;
			}
			triRapide(e.rapport,e);
		}

	}

	public static void triRapide(float tableau[],EndPoint e) {
		int longueur=tableau.length;
		triRapide(tableau,0,longueur-1, e);
		inverseF(e.rapport);
		inverseR(e.requests);
		
	}

	private static int partition(float tableau[],int deb,int fin,EndPoint e) {
		int compt=deb;
		float pivot=tableau[deb];

		for(int i=deb+1;i<=fin;i++)
		{
			if (tableau[i]<pivot)
			{
				compt++;
				float tmp = tableau[compt];
				tableau[compt]=tableau[i];
				tableau[i]=tmp;
				Request tmp2 = e.requests[compt];
				e.requests[compt]=e.requests[i];
				e.requests[i]=tmp2;
			}
		}
		float tmp = tableau[compt];
		tableau[compt]=tableau[deb];
		tableau[deb]=tmp;
		Request tmp2 = e.requests[compt];
		e.requests[compt]=e.requests[deb];
		e.requests[deb]=tmp2;
		return(compt);
	}

	private static void triRapide(float tableau[],int deb,int fin, EndPoint e) {
		if(deb<fin)
		{
			int positionPivot=partition(tableau,deb,fin,e);
			triRapide(tableau,deb,positionPivot-1,e);
			triRapide(tableau,positionPivot+1,fin,e);
		}
	}

	private static void inverseF(float t[]) {
		int c = t.length-1;
		for(int i=0;i<t.length;i++) {
			float tmp = t[i];
			t[i]= t[c];
			t[c]=tmp;
			c=c-1;
		}
	}
	private static void inverseR(Request t[]) {
		int c = t.length-1;
		for(int i=0;i<t.length;i++) {
			Request tmp = t[i];
			t[i]= t[c];
			t[c]=tmp;
			c=c-1;
		}
	}

}
