import React from 'react'
import Reducer from '../State/Reducer/Reducer';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import Signup from './Signup';
import { useLocation } from 'react-router';
import Login from './Login';
const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 500,
    bgcolor: 'background.paper',
    outline:'none',
    boxShadow: 24,
    p: 4,
  };

const AuthModel = ({handleClose,open}) => {
    const location=useLocation();

  return (
    <div>
        <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
            {location.pathname==="/login"? <Login/>:<Signup/>}
          <Typography id="modal-modal-title" variant="h6" component="h2">
            
          </Typography>
          {/* <Signup/> */}
        </Box>
      </Modal>
      
    </div>
  )
}

export default AuthModel
