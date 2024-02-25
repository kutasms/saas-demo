package org.example.saas.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.example.saas.core.service.user.BalanceBillService;
import org.example.saas.core.domain.dto.BalanceBillDTO;
import org.example.saas.core.pojo.BalanceBill;
import org.example.saas.core.parameter.user.BalanceBillDetailGetParameter;
import org.example.saas.core.parameter.user.BalanceBillPageGetParameter;
import org.example.saas.core.parameter.user.BalanceBillDeleteParameter;
import org.example.saas.core.parameter.user.BalanceBillSaveParameter;
import org.example.saas.core.parameter.user.BalanceBillUpdateParameter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.chia.multienty.core.annotation.WebLog;
import com.chia.multienty.core.domain.basic.Result;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * <p>
 * 余额账单 服务
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@RestController
@Validated
@RequestMapping("/balance-bill")
@RequiredArgsConstructor
@Api(tags = "余额账单")
public class BalanceBillController {
    private final BalanceBillService balanceBillService;

    @PostMapping("/detail")
    @ApiOperation("获取余额账单详情")
    public Result<BalanceBillDTO> getDetail(@Validated @RequestBody BalanceBillDetailGetParameter parameter) {
        BalanceBillDTO detail = balanceBillService.getDetail(parameter);
        return new Result<>(detail);
    }

    @PostMapping("/page")
    @ApiOperation("获取余额账单分页列表")
    public Result<IPage<BalanceBillDTO>> getPage(@Validated @RequestBody BalanceBillPageGetParameter parameter) {
        IPage<BalanceBillDTO> page = balanceBillService.getPage(parameter);
        return new Result<>(page);
    }

    @PostMapping("/update")
    @ApiOperation("更新余额账单")
    @WebLog
    public Result<Boolean> update(@Validated @RequestBody BalanceBillUpdateParameter parameter) {
        balanceBillService.update(parameter);
        return new Result<>(true);
    }

    @PostMapping("/save")
    @ApiOperation("保存余额账单")
    @WebLog
    public Result<Boolean> save(@Validated @RequestBody BalanceBillSaveParameter parameter) {
        balanceBillService.save(parameter);
        return new Result<>(true);
    }


    @DeleteMapping("/delete")
    @ApiOperation("删除余额账单")
    @WebLog
    public Result<Boolean> delete(@Validated @RequestBody BalanceBillDeleteParameter parameter) {
        balanceBillService.delete(parameter);
        return new Result<>(true);
    }

}
