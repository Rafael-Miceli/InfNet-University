using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RafaelMiceliAV1
{
    public partial class RafaelMiceliObrigado : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            TextBox txtCoffeType = (TextBox)Page.PreviousPage.FindControl("ctl00$ContentPlaceHolder1$txtCoffeType");

            if (txtCoffeType != null)
            {
                lblCoffeType.Text = txtCoffeType.Text;
            }

            TextBox txtBeginTime = (TextBox)Page.PreviousPage.FindControl("ctl00$ContentPlaceHolder1$RafaelMiceliuccafe$txtBeginTime");

            if (txtBeginTime != null)
            {
                lblBeginTime.Text = txtBeginTime.Text;
            }

            TextBox txtEndTime = (TextBox)Page.PreviousPage.FindControl("ctl00$ContentPlaceHolder1$RafaelMiceliuccafe$txtEndTime");

            if (txtEndTime != null)
            {
                lblEndTime.Text = txtEndTime.Text;
            }

        }
    }
}