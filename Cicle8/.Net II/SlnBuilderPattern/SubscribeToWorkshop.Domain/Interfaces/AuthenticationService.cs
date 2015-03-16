using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubscribeToWorkshop.Domain.Interfaces
{
    public interface AuthenticationService<T>
    {
        bool Login(string username, string password);
        bool IsAuthorized(T user);
    }
}
