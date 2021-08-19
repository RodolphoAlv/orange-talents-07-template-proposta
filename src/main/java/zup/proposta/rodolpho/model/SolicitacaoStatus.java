package zup.proposta.rodolpho.model;

public enum SolicitacaoStatus {
    COM_RESTRICAO {
        @Override
        public CartaoStatus toCartaoStatus() {
            return CartaoStatus.NAO_ELEGIVEL;
        }
    },
    SEM_RESTRICAO {
        @Override
        public CartaoStatus toCartaoStatus() {
            return CartaoStatus.ELEGIVEL;
        }
    };

    public abstract CartaoStatus toCartaoStatus();
}
