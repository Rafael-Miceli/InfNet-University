package View;

import Domain.Promotion;
import Domain.Supplier;
import Presentation.PromotionService;
import Presentation.SupplierService;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class Screen
{
    public static void main(String args[])
    {
        boolean run = true;

        SupplierService supplierService = new SupplierService();
        PromotionService promotionService = new PromotionService();

        while(run)
        {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar Fornecedor: ");
            System.out.println("2 - Cadastrar Promoção: ");
            System.out.println("3 - Buscar Promoção: ");
            System.out.println("4 - Sair: ");

            String strOpt = JOptionPane.showInputDialog("Escolha uma das opçoes anteriores");
            Integer opt = 0;

            try
            {
                opt = Integer.parseInt(strOpt);
            }
            catch(Exception ex)
            {
                ex.getStackTrace();
            }

            switch (opt)
            {
                case 1:
                    supplierService.CreateSupplier();
                    break;
                case 2:
                    promotionService.CreatePromotion();
                    break;
                case 3:
                    Promotion selectedPromotion = promotionService.FindPromotionByCode(JOptionPane.showInputDialog("Digite o código a ser buscado."));
                    if (selectedPromotion == null)
                        System.out.println("Promoção não encontrada");
                    else
                    {
                        System.out.println("Código: " + selectedPromotion.GetCode());
                        System.out.println("Título: " + selectedPromotion.GetTitle());
                        System.out.println("Fornecedor: " + selectedPromotion.GetSupplier().GetRazaoSocial());
                    }
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.print("Opção invalida, selecione novamente");
                    break;
            }
        }
    }

}
