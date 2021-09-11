package org.ppsspp.ppsspp;

import android.media.AudioManager.OnAudioFocusChangeListener;

public class AudioFocusChangeListener implements OnAudioFocusChangeListener {
    private boolean hasAudioFocus = false;

    public boolean hasAudioFocus() {
        return this.hasAudioFocus;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            this.hasAudioFocus = false;
        } else if (i == 1) {
            this.hasAudioFocus = true;
        }
    }
}
