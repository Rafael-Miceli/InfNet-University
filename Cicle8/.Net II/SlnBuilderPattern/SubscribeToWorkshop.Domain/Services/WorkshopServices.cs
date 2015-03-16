using SubscribeToWorkshop.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubscribeToWorkshop.Domain
{
    public class WorkshopServices : IWorkshopServices
    {
        public WorkshopServices(CloudService<Workshop> cloudService)
        {

        }

        public bool CreateWorkshop(string workshopName, string workshopDate)
        {
            return true;
        }

        public List<Workshop> ListWorkshops()
        {
            return new List<Workshop>();
        }
    }
}
