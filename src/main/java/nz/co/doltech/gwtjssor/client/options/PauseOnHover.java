package nz.co.doltech.gwtjssor.client.options;

public enum PauseOnHover {
    NO_PAUSE(0),
    PAUSE_DESKTOP(1),
    PAUSE_TOUCH(2),
    PAUSE_DESKTOP_TOUCH(3),
    FREEZE_DESKTOP(4),
    FREEZE_TOUCH(8),
    FREEZE_DESKTOP_TOUCH(12);

    public int pauseOnHover;
    PauseOnHover(int pauseOnHover) {
        this.pauseOnHover = pauseOnHover;
    }
}
