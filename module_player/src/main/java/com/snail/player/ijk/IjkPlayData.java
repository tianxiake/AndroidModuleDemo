package com.snail.player.ijk;

import java.io.Serializable;

public class IjkPlayData implements Serializable {

	private String url;
	private String playType;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("IjkPlayData{");
		sb.append("url='").append(url).append('\'');
		sb.append(", playType='").append(playType).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
