package mins.study.user.service.scanTarget;

import mins.study.user.config.PassComponentScan;
import org.springframework.stereotype.Component;

@PassComponentScan
@Component
public class NotScanTargetService02 {

    public NotScanTargetService02() {
        System.out.println(">>>>>>> Created NotScanTargetService02");
    }
}
