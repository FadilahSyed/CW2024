package com.example.demo.projectiles;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

import com.example.demo.actors.ActiveActorDestructible;

public abstract class Projectile extends ActiveActorDestructible {

	//private Rectangle hitbox;
	public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		//this.hitbox=new Rectangle(initialXPos,initialYPos,getImageWidth(), getImageHeight());
	}

	@Override
	public void takeDamage() {
		this.destroy();
	}

	public abstract void updatePosition();	/*
	@Override
	public void updatePosition() {
		super.updatePosition();
		updateHitbox();
	}
	public Rectangle getHitbox(){
		return hitbox;
	}
	private void updateHitbox() {
		hitbox.setX(getLayoutX()+getTranslateX());
		hitbox.setY(getLayoutY()+getTranslateY());
	}*/

}
