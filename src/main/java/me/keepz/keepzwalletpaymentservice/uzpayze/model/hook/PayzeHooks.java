package me.keepz.keepzwalletpaymentservice.uzpayze.model.hook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayzeHooks {

    private String webhookGateway;
    private String successRedirectGateway;
    private String errorRedirectGateway;

}
