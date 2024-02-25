package org.example.saas.core.service.user;

import org.example.saas.core.pojo.BalanceBill;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.BalanceBillDTO;
import org.example.saas.core.parameter.user.BalanceBillDetailGetParameter;
import org.example.saas.core.parameter.user.BalanceBillPageGetParameter;
import org.example.saas.core.parameter.user.BalanceBillDeleteParameter;
import org.example.saas.core.parameter.user.BalanceBillSaveParameter;
import org.example.saas.core.parameter.user.BalanceBillUpdateParameter;
/**
 * <p>
 * 余额账单 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
public interface BalanceBillService extends KutaBaseService<BalanceBill> {

    BalanceBillDTO getDetail(BalanceBillDetailGetParameter parameter);

    void delete(BalanceBillDeleteParameter parameter);

    IPage<BalanceBillDTO> getPage(BalanceBillPageGetParameter parameter);

    void save(BalanceBillSaveParameter parameter);

    void update(BalanceBillUpdateParameter parameter);

}
