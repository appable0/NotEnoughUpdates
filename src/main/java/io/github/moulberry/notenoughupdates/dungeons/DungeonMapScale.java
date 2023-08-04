/*
 * Copyright (C) 2023 NotEnoughUpdates contributors
 *
 * This file is part of NotEnoughUpdates.
 *
 * NotEnoughUpdates is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * NotEnoughUpdates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with NotEnoughUpdates. If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.moulberry.notenoughupdates.dungeons;

import java.awt.*;

public class DungeonMapScale {
	private static final int MAP_SIZE = 128;
	private static final int CONNECTION_SIZE = 4;
	private static final int MAP_PADDING = 5;

	private final int cornerX;
	private final int cornerY;
	private final int roomSize;

	public final int roomCountX;
	public final int roomCountY;

	public int getCenterX(int roomX) {
		return getCornerX(roomX) + roomSize / 2;
	}

	public int getCenterY(int roomY) {
		return getCornerY(roomY) + roomSize / 2;
	}

	public int getCornerX(int roomX) {
		return cornerX + (roomSize + CONNECTION_SIZE) * roomX;
	}

	public int getCornerY(int roomY) {
		return cornerX + (roomSize + CONNECTION_SIZE) * roomY;
	}

	public boolean isValid() {
		if (roomSize < 16 || roomSize > 18) return false;
		switch (cornerY) {
			case 5: return cornerX == 5 || cornerX == 16;
			case 11: return cornerX == 11 || cornerX == 22;
			case 16: return cornerX == 16;
			default: return false;
		}
	}

	public DungeonMapScale(Color[][] colourMap)  {
		int entranceStartX = -1;
		int entranceStartY = -1;
		int roomSize = -1;
		for (int x = 0; x < MAP_SIZE; x++) {
			for (int y = 0; y < MAP_SIZE; y++) {
				Color colour = colourMap[x][y];
				if (colour.equals(RoomColor.GREEN.color)) {
					if (entranceStartX == -1) {
						entranceStartX = x;
						entranceStartY = y;
					}
				} else if (entranceStartX != -1 && roomSize == -1) {
					roomSize = y - entranceStartY;
				}
			}
		}
		this.roomSize = roomSize;
		int roomConnectionSize = this.roomSize + CONNECTION_SIZE;
		this.cornerX = (entranceStartX - MAP_PADDING) % (roomConnectionSize) + MAP_PADDING;
		this.cornerY = (entranceStartY - MAP_PADDING) % (roomConnectionSize) + MAP_PADDING;
		this.roomCountX = (MAP_SIZE - this.cornerX) / roomConnectionSize;
		this.roomCountY = (MAP_SIZE - this.cornerY) / roomConnectionSize;
	}
}

