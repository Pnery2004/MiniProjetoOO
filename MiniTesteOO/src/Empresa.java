
public abstract class Empresa {
		 private static int CEP;
		 private  static String Endereco;
		 private static String CNPJ;
		 
		public int getCEP() {
			return CEP;
		}
		public static void setCEP(int cEP) {
			CEP = cEP;
		}
		public String getEndereco() {
			return Endereco;
		}
		public static void setEndereco(String endereco) {
			Endereco = endereco;
		}
		public String getCNPJ() {
			return CNPJ;
		}
		public static void setCNPJ(String string) {
			CNPJ = string;
		}	
		 
		}

