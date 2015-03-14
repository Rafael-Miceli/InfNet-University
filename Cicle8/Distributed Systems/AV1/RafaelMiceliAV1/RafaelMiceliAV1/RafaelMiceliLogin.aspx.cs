using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RafaelMiceliAV1
{
    public partial class RafaelMiceliLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            RafaelMiceliPrincipal masterPage = (RafaelMiceliPrincipal)Master;

            masterPage.Im("Login");
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            if (txtLogin.Text == txtPassword.Text)
            {
                Session["Login"] = txtLogin.Text;
                Response.Redirect("~/RafaelMiceliHome.aspx");
            }
        }
    }
}