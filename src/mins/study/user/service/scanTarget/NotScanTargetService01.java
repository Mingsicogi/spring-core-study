package mins.study.user.service.scanTarget;

import mins.study.user.config.PassComponentScan;
import org.springframework.stereotype.Component;

@PassComponentScan
@Component
public class NotScanTargetService01 {
    public NotScanTargetService01() {
        System.out.println(">>>>>>> Created NotScanTargetService01");
    }
}
