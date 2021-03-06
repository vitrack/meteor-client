/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2020 Meteor Development.
 */

package minegame159.meteorclient.mixininterface;

public interface IPlayerMoveC2SPacket {
    void setY(double y);
    void setOnGround(boolean onGround);
    void setYaw(float yaw);
    void setPitch(float pitch);
    int getTag();
    void setTag(int tag);
}
