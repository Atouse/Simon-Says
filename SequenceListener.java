package SimonSays;

public class SequenceListener extends Thread {
	private ColourSquare[] squares;
	private View listenView;
	
	public int[] generated; // generated sequence
	private final int[] RESET = {5,5,5,5}; // reset default user input sequence arr
	private int state;
	private SequenceGenerator in;
	public SequenceListener(ColourSquare[] squares, SequenceGenerator in,View view) {
		this.squares = squares;
		this.in=squares[0].in;
		this.listenView=view;
	
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("");
			if(this.in.sequenceInput[3] != 5) {
				if(Utils.areEqual(this.generated,this.in.sequenceInput)) {
					listenView.correctScreen();
				}
				else {
					listenView.endScreen();
				}
				this.currentThread().stop();
				this.in.sequenceInput = this.RESET;
			}
			
		}
		
	}//run method
	
	
}
