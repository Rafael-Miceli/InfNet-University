using SubscribeToWorkshop.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubscribeToWorkshop.Domain.Services
{
    public class AwsService<T> : CloudService<T>
    {
        public void Add(T entity)
        {
            throw new NotImplementedException();
        }
    }
}
