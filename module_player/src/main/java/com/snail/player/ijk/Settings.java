/*
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.snail.player.ijk;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Settings {

	public static final int PV_PLAYER__Auto = 0;
	public static final int PV_PLAYER__AndroidMediaPlayer = 1;
	public static final int PV_PLAYER__IjkMediaPlayer = 2;
	//播播项目直播流exo播不了
	public static final int PV_PLAYER__IjkExoMediaPlayer = 3;

	public boolean enableBackgroundPlay = true; // 是否允许后台播放
	public static int player = PV_PLAYER__AndroidMediaPlayer;
	/**
	 * 启用硬解，ijk必须要启用硬解,不然会很卡
	 */
	public boolean usingMediaCodec = true;
	public boolean usingMediaCodecAutoRotate = false;
	public boolean usingOpenSLES = false;
	public String pixelFormat = "";
	// 没有View显示，比如播放音乐时
	public boolean enableNoView = false;
	// 使用surfaceView
	public boolean enableSurfaceView = true;
	// 使用TextureView
	public boolean enableTextureView = false;
	public boolean enableDetachedSurfaceTextureView = false;

	public Settings(Context context) {

	}

	public boolean getEnableBackgroundPlay() {
		return enableBackgroundPlay;
	}

	public static int getDefaultPlayer() {
		return player;
	}

	public boolean getUsingMediaCodec() {
		return usingMediaCodec;
	}

	public boolean getUsingMediaCodecAutoRotate() {
		return usingMediaCodecAutoRotate;
	}

	public boolean getUsingOpenSLES() {
		return usingOpenSLES;
	}

	public String getPixelFormat() {
		return pixelFormat;
	}

	public boolean getEnableNoView() {
		return enableNoView;
	}

	public boolean getEnableSurfaceView() {
		return enableSurfaceView;
	}

	public boolean getEnableTextureView() {
		return enableTextureView;
	}

	public boolean getEnableDetachedSurfaceTextureView() {
		return enableDetachedSurfaceTextureView;
	}

	/**
	 * 是否支持 hevc 硬解
	 *
	 * @return
	 */
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public static boolean isH265HWDecoderSupport() {
		MediaCodecList codecList = new MediaCodecList(MediaCodecList.REGULAR_CODECS);
		// 获取设备支持的所有 codec 信息
		MediaCodecInfo[] codecInfos = codecList.getCodecInfos();
		for (int i = 0; i < codecInfos.length; i++) {
			MediaCodecInfo codecInfo = codecInfos[i];
			// 解码codec & 解码器名称包含'hevc' & 不是软件codec
			if (!codecInfo.isEncoder() && (codecInfo.getName().contains("hevc") && !isSWCodec(codecInfo.getName()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否为软件 codec
	 *
	 * @param codecName
	 * @return
	 */
	public static boolean isSWCodec(String codecName) {
		if (codecName.startsWith("OMX.google.")) {
			return true;
		}

		if (codecName.startsWith("OMX.")) {
			return false;
		}
		return true;
	}
}
