using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RafaelMiceliAV1
{
    public partial class RafaelMiceliCafe : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegisterCoffe_Click(object sender, EventArgs e)
        {
            Server.Transfer("~/RafaelMiceliObrigado.aspx", true);
        }
    }
}