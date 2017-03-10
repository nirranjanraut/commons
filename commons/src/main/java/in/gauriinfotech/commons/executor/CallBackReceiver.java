package in.gauriinfotech.commons.executor;

import java.util.List;
import java.util.Map;

/**
 * Created by NiRRaNjAN on 20/10/16.
 */
public interface CallBackReceiver {

    void onDone(List<Map<String, String>> result);

}