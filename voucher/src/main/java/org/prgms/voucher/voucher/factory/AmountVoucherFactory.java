package org.prgms.voucher.voucher.factory;

import org.prgms.voucher.voucher.AmountVoucher;

import java.util.UUID;

public interface AmountVoucherFactory {
    AmountVoucher createVoucher(int amount);
}
