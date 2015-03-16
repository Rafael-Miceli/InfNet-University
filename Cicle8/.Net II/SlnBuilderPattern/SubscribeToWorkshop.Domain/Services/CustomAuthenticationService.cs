using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SubscribeToWorkshop.Domain.Interfaces;
using SubscribeToWorkshop.Domain.Models;

namespace SubscribeToWorkshop.Domain.Services
{
    public class CustomAuthenticationService : AuthenticationService<User>
    {
        private CloudService<User> _cloudService;

        public CustomAuthenticationService(CloudService<User> cloudService)
        {
            _cloudService = cloudService;
        }

        public bool IsAuthorized(User user)
        {
            return true;
        }

        public bool Login(string username, string password)
        {
            throw new NotImplementedException();
        }
    }
}
