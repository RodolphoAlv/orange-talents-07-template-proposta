package zup.proposta.rodolpho.model;

public enum SolicitacaoStatus {
    COM_RESTRICAO {
        @Override
        public PropostaStatus toCartaoStatus() {
            return PropostaStatus.NAO_ELEGIVEL;
        }
    },
    SEM_RESTRICAO {
        @Override
        public PropostaStatus toCartaoStatus() {
            return PropostaStatus.ELEGIVEL;
        }
    };

    public abstract PropostaStatus toCartaoStatus();
}
