package View;

import Domain.Promotion;
import Presentation.PromotionService;
import Presentation.SupplierService;

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

//        while(run)
//        {
//            System.out.println("Escolha uma opção: ");
//            System.out.println("1 - Cadastrar Fornecedor: ");
//            System.out.println("2 - Cadastrar Promoção: ");
//            System.out.println("3 - Buscar Promoção: ");
//            System.out.println("4 - Sair: ");
//
//            String opt = JOptionPane.showInputDialog("Escolha uma das opçoes anteriores");
//
//            switch (opt)
//            {
//                case "1":
//
//                    break;
//                case "2":
//                    break;
//                case "3":
//                    break;
//                case "4":
//                    break;
//                default:
//                    break;
//            }
//        }


        SupplierService supplierService = new SupplierService();

       //supplierService.CreateSupplier();
       //supplierService.GetSuppliers();

        PromotionService promotionService = new PromotionService();

        //promotionService.CreatePromotion();

        for (Promotion promotion: promotionService.GetPromotions())
        {
            System.out.println(promotion.GetTitle());
            System.out.println(promotion.GetSupplier().GetRazaoSocial());
        }

    }

}
