package com.whatthehack.ctrl.yourself.helpers;

import com.whatthehack.ctrl.yourself.game.GameManager;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardHandler implements NativeKeyListener {

    public static final int ALL_F_KEYS = (NativeKeyEvent.VC_F1 | NativeKeyEvent.VC_F2
            | NativeKeyEvent.VC_F3 | NativeKeyEvent.VC_F4 | NativeKeyEvent.VC_F5
            | NativeKeyEvent.VC_F6 | NativeKeyEvent.VC_F7 | NativeKeyEvent.VC_F8
            | NativeKeyEvent.VC_F9 | NativeKeyEvent.VC_F10 | NativeKeyEvent.VC_F11
            | NativeKeyEvent.VC_F12);

    private GameManager gameManager;

    public KeyboardHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent key) {
        // ESC
        if (key.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            handleEsc();
        }

        // ALT
        if ((key.getModifiers() & NativeInputEvent.ALT_MASK) != 0) {
            handleAlt(key.getKeyCode());
        }

        // CTRL
        if ((key.getModifiers() & NativeInputEvent.CTRL_MASK) != 0) {
            handleCtrl(key.getKeyCode());
        }

        // CTRL-ALT
        if ((key.getModifiers() & NativeInputEvent.CTRL_MASK) != 0) {
            if ((key.getModifiers() & NativeInputEvent.ALT_MASK) != 0) {
                handleCtrlAlt(key.getKeyCode());
            }
        }

        // CTRL-SHIFT
        if ((key.getModifiers() & NativeInputEvent.CTRL_MASK) != 0) {
            if ((key.getModifiers() & NativeInputEvent.SHIFT_MASK) != 0) {
                handleCtrlShift(key.getKeyCode());
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    // HANDLER DEFINITIONS
    public void handleEsc() {
        // ESC
    }

    public void handleAlt(int keyCode) {

        switch (keyCode) {
            /*
            case NativeKeyEvent.VC_F4: // ALT F4
                gameManager.launchChallenge(); // random
                break;
             */
            case NativeKeyEvent.VC_TAB: //ALT TAB
                gameManager.launchChallenge(); // random
                break;
        }
    }

    public void handleCtrl(int keyCode) {
        // CTRL T, C, Z, V, S, X
        switch (keyCode) {
            case NativeKeyEvent.VC_A:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_C:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_F:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_S:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_T:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_V:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_X:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_Y:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_Z:
                gameManager.launchChallenge(); // random
                break;
        }
    }

    public void handleCtrlAlt(int keyCode) {
        // CTRL-ALT DEL, F1..12
        switch (keyCode) {
            case NativeKeyEvent.VC_DELETE:
                gameManager.launchChallenge(); // random
                break;
            case ALL_F_KEYS:
                gameManager.launchChallenge(); // random
                break;

        }
    }

    public void handleCtrlShift(int keyCode) {
        // CTRL-SHIFT Z, N, P
        switch (keyCode) {
            case NativeKeyEvent.VC_N:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_P:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_T:
                gameManager.launchChallenge(); // random
                break;
            case NativeKeyEvent.VC_Z:
                gameManager.launchChallenge(); // random
                break;
        }
    }
}
