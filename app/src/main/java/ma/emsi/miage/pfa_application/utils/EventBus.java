package ma.emsi.miage.pfa_application.utils;

import com.squareup.otto.Bus;

/**
 * Created by ABD3LKAR1M on 03/12/2017.
 */

public class EventBus extends Bus{
    private static final EventBus bus = new EventBus();

    public static Bus getInstance(){return bus;}

    private EventBus() {}
}
