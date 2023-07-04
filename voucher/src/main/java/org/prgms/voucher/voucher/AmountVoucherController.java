package org.prgms.voucher.voucher;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AmountVoucherController {
    private final AmountVoucherService amountVoucherService;
    private static final int INITIAL_MONEY = 100_000;

    public AmountVoucherController(AmountVoucherService amountVoucherService) {
        this.amountVoucherService = amountVoucherService;
    }

    public AmountVoucher createAmountVoucher(AmountVoucherCreateDto amountVoucherCreateDto) {
        return amountVoucherService.createAmountVoucher(amountVoucherCreateDto.getCreateAmountVoucher());
    }

    public String listVoucher() {
        List<AmountVoucher> amountVouchers = amountVoucherService.listAmountVoucher();

        StringBuilder sb = new StringBuilder();
        amountVouchers.stream()
                .map(voucher -> new VoucherPrintDto(
                        voucher.getOptionTypeName(),
                        voucher.discount(INITIAL_MONEY),
                        voucher.getPublishDate(),
                        voucher.getExpirationDate()))
                .forEach(voucherPrintDto -> sb.append("\n").append(voucherPrintDto.getVoucherPrint()));

        return sb.toString();
    }
}
