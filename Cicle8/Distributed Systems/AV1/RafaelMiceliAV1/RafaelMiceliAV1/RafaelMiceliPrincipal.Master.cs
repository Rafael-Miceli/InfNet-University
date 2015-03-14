using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RafaelMiceliAV1
{
    public partial class RafaelMiceliPrincipal : System.Web.UI.MasterPage
    {
        private string _pageName;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Login"] == null && _pageName != "Login")
            {
                Response.Redirect("~/RafaelMiceliLogin.aspx");
            }
        }

        public void Im(string pageName)
        {
            _pageName = pageName;    
        }
    }
}