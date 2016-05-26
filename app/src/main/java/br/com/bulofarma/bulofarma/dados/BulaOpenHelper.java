package br.com.bulofarma.bulofarma.dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Katrina on 25/05/2016.
 */
public class BulaOpenHelper extends SQLiteOpenHelper {

        public static final String TABELA_BULA = "bula";
        private static final String DATABASE_NAME = "bula_database";
        private static final int DATABASE_VERSION = 1;
        private static final String SQL_TABELA_BULA = "CREATE TABLE " + TABELA_BULA + "(" +
                "titulo text not null primary key," +
                "composicao text not null," +
                "indicacoes text not null," +
                "contraindicacoes text not null," +
                "modousar text not null," +
                "posologia text not null," +
                "advertencias text not null," +
                "efeitocolateral text not null," +
                "favorito integer not null)";
        private static final String SQL_INSERT_BULA = "insert into " + TABELA_BULA + "(titulo," +
                "composicao,indicacoes,contraindicacoes,modousar,posologia,advertencias,efeitocolateral" +
                ",favorito) values ('BulaTeste'," +
                "'3% de FILPITNA, 29% de Tertina, 68% de Catapina','Indicado para pessoas com " +
                "diabetes com idade abaixo de 60 anos, sendo assim administrado por um médico, " +
                "não devendo ser ministrador por menores de 18 anos e pessoas sem experiência','Não" +
                "indicado para mulheres grávidas','Utilização de uma seringa para fazer aplicação da" +
                " dosagem necessária','3 vezes ao dia','O ácido acetilsalicílico, que devido a algumas" +
                " de suas propriedades prolonga o tempo de coagulação sanguínea, não " +
                "deve ser usado em altas doses nos últimos três meses de gestação, exceto sob " +
                "estrito acompanhamento médico, pois pode causar problemas no feto ou complicações " +
                "durante o parto." +
                "O mesmo cuidado deve ser tomado em relação às mulheres que estejam amamentando'," +
                "'BulaTeste está contraindicado em todos os pacientes com hipersensibilidade ao " +
                "ácido acetilsalicílico e a outros anti-inflamatórios não esteroides.'," +
                "'1')";
    private static final String SQL_INSERT_BULA2 = "insert into " + TABELA_BULA + "(titulo," +
            "composicao,indicacoes,contraindicacoes,modousar,posologia,advertencias,efeitocolateral,favorito)" +
            " values ('Curitybina','Solução: Ácido salicílico 0,100 g/ml. " +
            "Excipientes: Álcool etílico , óleo de rícino , essência de terebentina , " +
            "colódio elástico, éter etílico, ácido acético glacial ." +
            " Pasta: Acido salicílico - 0,280 g/g. " +
            "Excipientes:Negro de fumo , parafina sólida , petrolato , metilparabeno , propilparabeno'," +
            "'É indicado no tratamento e remoção das verrugas comuns e como calicida .'," +
            "'O produto não deve ser usado por pacientes com hipersensibilidade aos componentes da " +
            "fórmula. A solução tópica não deve ser utilizada em pele inflamada, irritada ou " +
            "infeccionada, em pacientes diabéticos ou com doença vascular periférica; em verrugas " +
            "faciais, genitais, orais; verrugas com pêlo, pintas e marcas de nascença.','Antes da " +
            "aplicação de a Curitybina, lavar a área afetada com água e secar cuidadosamente; caso " +
            "esteja tratando verrugas, deixar a área afetada em contato com água morna por 5 minutos" +
            " e secar cuidadosamente. Pasta: proteger a área que circunda a verruga ou calo, aplicando" +
            " um pedaço de esparadrapo, com um orifício central, do mesmo tamanho da verruga ou calo," +
            " de maneira que somente a verruga ou calo fique visível. Aplicar quatro camadas do produto" +
            " diretamente sobre a verruga ou calo, uma vez ao dia, evitando contato com a pele normal" +
            " que circunda a verruga ou calo. A aplicação deve ser efetuada diariamente, de preferência" +
            " à noite. Quando a Curitybina estiver completamente seca sobre a verruga ou calo, " +
            "recomenda-se cobrir a mesma com um esparadrapo ou curativo adesivo. " +
            "Solução tópica: não utilizar a Curitybina solução tópica perto de chamas ou quando estiver fumando," +
            " evite inalar o produto. Aplicar o medicamento gota a gota o suficiente para cobrir " +
            "cada verruga, calo ou calosidade, deixar secar. O procedimento pode ser repetido 1 a 2 " +
            "vezes ao dia por 14 dias para calos ou calosidades ou até 12 semanas para verrugas, " +
            "até que a verruga, calo ou calosidade seja removida. Para auxiliar na remoção dos calos" +
            " e as calosidades deixar em contato com água morna por 5 minutos. Caso seja esquecida " +
            "uma dose, aplicar assim que possível, contanto que o tempo da aplicação não seja o da " +
            "próxima dose.','Aplicar o medicamento gota a gota o suficiente para cobrir cada verruga," +
            " calo ou calosidade','Gerais: deve ser considerado o risco/benefício para a utilização " +
            "dos produtos em pacientes com diabetes mellitus, doença vascular periférica " +
            "(poderá ocorrer inflamação ou ulceração aguda, especialmente das extremidades), " +
            "inflamação, irritação ou infecção da pele. Pediatria: não foram realizados estudos " +
            "apropriados em relação idade/ efeitos do medicamento na população pediátrica. " +
            "Contudo, o risco de toxicidade é aumentado em crianças pequenas por causa da alta " +
            "absorção do ácido salicílico através da pele e da área total da superfície corporal " +
            "sendo tratada. Também podem apresentar baixo limiar para irritação da pele. " +
            "Em crianças o ácido salicílico não deve ser aplicado em áreas extensas do corpo, " +
            "durante longos períodos de tempo e deve-se evitar a oclusão de extensas áreas cutâneas.'," +
            "'O tratamento de verrugas utilizando altas concentrações de ácido salicílico pode causar" +
            " erosão cutânea que pode facilitar o espalhamento das verrugas. Os seguintes efeitos " +
            "adversos foram selecionados baseados em seu significado clínico: Incidência menos " +
            "freqüente ou rara: irritação cutânea moderada a severa, não presente antes do tratamento;" +
            " ulceração ou erosão cutânea, especialmente quando for utilizado medicamentos com alta" +
            " porcentagem de ácido salicílico." +
            " Incidência mais freqüente: Irritação cutânea suave, não presente antes do tratamento " +
            "ou sensação de picada.','1')";



    public BulaOpenHelper(Context contexto){
            super(contexto,DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_TABELA_BULA);
            db.execSQL(SQL_INSERT_BULA);
            db.execSQL(SQL_INSERT_BULA2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


