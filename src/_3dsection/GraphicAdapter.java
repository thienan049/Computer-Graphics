package _3dsection;


import java.awt.Graphics;

abstract class GraphicAdapter {
	
	public Graphics GraphicAdapter;
	
	public GraphicAdapter(){
		
	}
            
	public GraphicAdapter(Graphics g){
		
		this.GraphicAdapter =  g;
	}

	public Graphics getGraphicAdapter() {
		
		return GraphicAdapter;
	}
	
	public void setGraphicAdapter(Graphics graphicAdapter) {
		
		GraphicAdapter = graphicAdapter;
	}
	
}
