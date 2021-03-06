package boulderdash.controller;

import java.io.IOException;

import boulderdash.model.IBoulderdashModel;
import boulderdash.view.IBoulderdashView;
import modele.dao.BddRequete;
import boulderdash.model.element.IElement;
import boulderdash.model.element.mobile.*;
import boulderdash.model.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Class BoulderdashController.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * @see IOrderPerformer
 * 
 */
public class BoulderdashController implements IBoulderdashController, IOrderPerformer {

	/** The Constant speed. */
	private static final int speed = 200;

	/** The view. */
	private IBoulderdashView view;

	/** The model. */
	private IBoulderdashModel model;
	

	/** The stack order. */
	private UserOrder stackOrder;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public BoulderdashController(final IBoulderdashView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * Execute the game
	 */
	@Override
	public final void play() throws InterruptedException {

		int kase = 0;
		int[] tabX = new int[10];
		int[] tabY = new int[10];
		int test = 0;

		int score = 0;
		int x = 0;
		int y = 0;
		while (this.getModel().getMyRockford().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getMyRockford().moveRight();
				if (this.getModel().getMyRockford().isBlocked() == true) {
					this.getModel().getMyRockford().moveLeft();
				}
				break;
			case LEFT:
				this.getModel().getMyRockford().moveLeft();
				if (this.getModel().getMyRockford().isBlocked() == true) {
					this.getModel().getMyRockford().moveRight();
				}
				break;
			case UP:
				this.getModel().getMyRockford().moveUp();
				if (this.getModel().getMyRockford().isBlocked() == true) {
					this.getModel().getMyRockford().moveDown();
				}
				break;
			case DOWN:
				this.getModel().getMyRockford().moveDown();
				if (this.getModel().getMyRockford().isBlocked() == true) {
					this.getModel().getMyRockford().moveUp();
				}
				break;
			case NOP:
			default:
				this.getModel().getMyRockford().doNothing();
				break;
			}
			this.clearStackOrder();

			if (this.getModel().getMyRockford().isWon() == true) {
				
				if (score == 10) {
					this.getView().displayMessage("YOU WIN");
					
					
					System.exit(0);
				}

			} else if (this.getModel().getMyRockford().isLootable() == true) {

				x = this.getModel().getMyRockford().getX();
				y = this.getModel().getMyRockford().getY();

				test = 0;
				for (int i = 0; i < 10; i++) {

					if (x == tabX[i] && y == tabY[i]) {

						test = 1;
					}
				}
				if (test != 1) {

					tabX[kase] = x;
					tabY[kase] = y;
					kase++;
					score++;
					System.out.println("Score = " + score);
				}

			}

			// if (this.getModel().getMyVehicle().isDesappear() == true){
			// IElement test = this.get
			// setOnTheRoadXY(,this.getModel().getMyVehicle().getX(),this.getModel().getMyVehicle().getY());
			// }

		}
		this.getView().displayMessage("GAME OVER");
		System.exit(0);

	}

	/**
	 * Order
	 * 
	 * @param userOrder
	 *            the order
	 */
	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IBoulderdashView getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the view to set
	 */
	private void setView(final IBoulderdashView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return model
	 * 			   the model
	 */
	private IBoulderdashModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the model to set
	 */
	private void setModel(final IBoulderdashModel model) {
		this.model = model;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/**
	 * Order
	 * 
	 * @return order
	 *            the order
	 */
	@Override
	public IOrderPerformer getOrderPeformer() {
		return this;
	}
}
