using SubscribeToWorkshop.Domain.Models;
using System.Collections.Generic;

namespace SubscribeToWorkshop.Domain
{
    public interface IWorkshopServices
    {
        bool CreateWorkshop(string workshopName, string workshopDate);
        List<Workshop> ListWorkshops();
    }
}