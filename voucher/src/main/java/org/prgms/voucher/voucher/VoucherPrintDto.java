package org.prgms.voucher.voucher;

import org.prgms.voucher.util.MessageUtils;

import static org.prgms.voucher.voucher.VoucherPrintType.*;

public class VoucherPrintDto {
    private final AmountVoucher amountVoucher;

    public VoucherPrintDto(AmountVoucher amountVoucher) {
        this.amountVoucher = amountVoucher;
    }

    public String getVoucherPrint() {
        return formatVoucherOutput(VOUCHER_TYPE, amountVoucher.getCreationTypeName())
                + formatVoucherOutput(DISCOUNT_AMOUNT, String.valueOf(amountVoucher.getDiscountAmount()))
                + formatVoucherOutput(PUBLISH_DATE, String.valueOf(amountVoucher.getPublishDate()))
                + formatVoucherOutput(EXPIRATION_DATE, String.valueOf(amountVoucher.getExpirationDate()));
    }

    private String formatVoucherOutput(VoucherPrintType voucherPrintType, String value) {
        return MessageUtils.getMessage(voucherPrintType.getType()) + ":" + value + "\n";
    }
}
